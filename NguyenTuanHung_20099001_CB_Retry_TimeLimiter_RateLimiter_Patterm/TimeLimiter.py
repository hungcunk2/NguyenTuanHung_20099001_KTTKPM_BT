import time

class TimeLimiter:
    GIOI_HAN_THOI_GIAN = 5

    def __init__(self):
        self.thoi_diem_bat_dau = None

    def thuc_thi(self, dich_vu):
        if not callable(dich_vu):
            raise ValueError("Đầu vào phải là một hàm hợp lệ")
        
        self.thoi_diem_bat_dau = time.time()
        try:
            ket_qua = dich_vu()
            thoi_gian_da_troi_qua = time.time() - self.thoi_diem_bat_dau
            if thoi_gian_da_troi_qua > self.GIOI_HAN_THOI_GIAN:
                raise RuntimeError("Vượt quá giới hạn thời gian (5 giây)")
            return ket_qua
        except Exception as e:
            self.xu_ly_loi(e)
        finally:
            self.dat_lai()

    def xu_ly_loi(self, e):
        if self.thoi_diem_bat_dau is None:
            raise RuntimeError("Thời điểm bắt đầu không hợp lệ")
        thoi_gian_da_troi_qua = time.time() - self.thoi_diem_bat_dau
        if thoi_gian_da_troi_qua > self.GIOI_HAN_THOI_GIAN:
            raise RuntimeError("Vượt quá giới hạn thời gian (5 giây)")
        raise e

    def dat_lai(self):
        self.thoi_diem_bat_dau = None

if __name__ == "__main__":
    import random

    def dich_vu_mo_phong():
        thoi_gian_ngau_nhien = random.uniform(1, 7)
        if thoi_gian_ngau_nhien >= 5.69:
            thoi_gian_ngau_nhien = 5.69
        time.sleep(thoi_gian_ngau_nhien)
        if random.random() > 0.5:
            return f"Thành công sau {thoi_gian_ngau_nhien:.2f} giây"
        raise RuntimeError(f"Dịch vụ thất bại sau {thoi_gian_ngau_nhien:.2f} giây")

    time_limiter = TimeLimiter()

    for i in range(10):
        try:
            ket_qua = time_limiter.thuc_thi(dich_vu_mo_phong)
            print(f"Yêu cầu {i+1}: {ket_qua}")
        except Exception as e:
            print(f"Lỗi yêu cầu {i+1}: {e}")
        time.sleep(1)