class RetryPattern:
    MAX_RETRIES = 2  # Số lần thử lại tối đa (tổng cộng 3 lần gọi: 1 lần đầu + 2 lần thử lại)

    def __init__(self):
        self.retry_count = 0

    def execute(self, supplier):
        # Thử gọi dịch vụ, tối đa 3 lần (1 lần đầu + 2 lần thử lại)
        while self.retry_count <= self.MAX_RETRIES:
            try:
                result = supplier()
                self.reset()  # Reset số lần thử lại nếu thành công
                return result
            except Exception as e:
                self.retry_count += 1
                print(f"Retry {self.retry_count}/{self.MAX_RETRIES}")
                if self.retry_count > self.MAX_RETRIES:
                    self.reset()
                    raise RuntimeError("Can not call") from e

    def reset(self):
        self.retry_count = 0

# Ví dụ sử dụng
if __name__ == "__main__":
    import random

    def unreliable_service():
        if random.random() > 0.7:
            return "Success"
        raise RuntimeError("Service failed")

    retry = RetryPattern()

    for i in range(5):  # Mô phỏng Postman gửi yêu cầu 5 lần
        try:
            result = retry.execute(unreliable_service)
            print(f"Attempt {i+1} - Result: {result}")
        except Exception as e:
            print(f"Attempt {i+1} - Error: {e}")
            break  # Dừng gọi sau khi nhận lỗi "Can not call"