import time

class CircuitBreaker:
    FAILURE_THRESHOLD = 3  # Số lần lỗi tối đa
    TIMEOUT_SECONDS = 5    # Thời gian thử lại (5 giây)

    def __init__(self):
        self.state = "closed"
        self.failure_count = 0
        self.start_time = None

    def execute(self, supplier):
        # Nếu mạch đang mở, ném lỗi ngay lập tức
        if self.is_open():
            raise RuntimeError("Can not call")

        # Nếu mạch đóng, bắt đầu thử gọi
        if self.is_closed():
            if self.start_time is None:
                self.start_time = time.time()

            # Thử gọi trong 5 giây
            while (time.time() - self.start_time) < self.TIMEOUT_SECONDS:
                try:
                    result = supplier()
                    self.reset()
                    return result
                except Exception as e:
                    self.handle_failure(e)
                    if self.is_open():
                        raise RuntimeError("Can not call")
                    time.sleep(1)  # Chờ 1 giây trước khi thử lại

            # Nếu vượt 5 giây mà vẫn lỗi, chuyển sang trạng thái open
            if self.failure_count > 0:
                self.set_open()
                raise RuntimeError("Can not call")

        raise ValueError("Invalid circuit breaker state")

    def handle_failure(self, e):
        self.failure_count += 1
        if self.failure_count >= self.FAILURE_THRESHOLD:
            self.set_open()
            print(f"Circuit breaker OPEN. Failure count: {self.failure_count}")
        else:
            print(f"Failure count: {self.failure_count}")

    def reset(self):
        self.failure_count = 0
        self.start_time = None
        self.state = "closed"

    def is_open(self):
        return self.state == "open"

    def is_closed(self):
        return self.state == "closed"

    def set_open(self):
        self.state = "open"

# Ví dụ sử dụng
if __name__ == "__main__":
    import random

    def unreliable_service():
        if random.random() > 0.7:
            return "Success"
        raise RuntimeError("Service failed")

    cb = CircuitBreaker()

    for i in range(10):
        try:
            result = cb.execute(unreliable_service)
            print(f"Result: {result}")
        except Exception as e:
            print(f"Error: {e}")