import time
from threading import Lock

class RateLimiter:
    DUNG_LUONG_TOI_DA = 5  # Số yêu cầu tối đa mỗi phút (5 RPM)
    THOI_GIAN_REFILL = 60  # Thời gian để làm đầy lại (60 giây cho 1 phút)

    def __init__(self):
        self.dung_luong = self.DUNG_LUONG_TOI_DA  # Dung lượng hiện tại
        self.toc_do_refill = self.DUNG_LUONG_TOI_DA / self.THOI_GIAN_REFILL  # Tốc độ làm đầy (yêu cầu/giây)
        self.thoi_diem_refill_cuoi = time.time()  # Thời điểm làm đầy cuối cùng
        self.khoa = Lock()  # Khóa để đảm bảo thread-safe

    def _lam_day(self):
        # Tính thời gian trôi qua và làm đầy lại dung lượng
        thoi_diem_hien_tai = time.time()
        thoi_gian_da_troi_qua = thoi_diem_hien_tai - self.thoi_diem_refill_cuoi
        yeu_cau_moi = thoi_gian_da_troi_qua * self.toc_do_refill
        self.dung_luong = min(self.DUNG_LUONG_TOI_DA, self.dung_luong + yeu_cau_moi)
        self.thoi_diem_refill_cuoi = thoi_diem_hien_tai

    def thuc_thi(self, dich_vu):
        with self.khoa:
            self._lam_day()  # Làm đầy lại dung lượng trước khi xử lý
            if self.dung_luong >= 1:
                self.dung_luong -= 1
                print(f"Yêu cầu được chấp nhận. Dung lượng còn lại: {self.dung_luong:.2f}")
                return dich_vu()
            else:
                print("Vượt quá giới hạn tốc độ (5 RPM).")
                raise RuntimeError("Vượt quá giới hạn tốc độ")

# Ví dụ sử dụng
if __name__ == "__main__":
    import random

    def dich_vu_mo_phong():
        # Mô phỏng một dịch vụ, trả về kết quả ngẫu nhiên
        if random.random() > 0.5:
            return "Thành công"
        raise RuntimeError("Dịch vụ thất bại")

    # Khởi tạo Rate Limiter
    rate_limiter = RateLimiter()

    # Mô phỏng 10 yêu cầu từ Postman
    for i in range(10):
        try:
            ket_qua = rate_limiter.thuc_thi(dich_vu_mo_phong)
            print(f"Kết quả yêu cầu {i+1}: {ket_qua}")
        except Exception as e:
            print(f"Lỗi yêu cầu {i+1}: {e}")
        time.sleep(1)  # Chờ 1 giây giữa các yêu cầu để mô phỏng thời gian