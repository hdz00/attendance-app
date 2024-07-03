package com.attendanceapp.service;

import com.attendanceapp.util.QRCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QRCodeService {

    @Autowired
    private QRCodeUtil qrCodeUtil;

    @Autowired
    private AttendanceService attendanceService;

    public byte[] generateQRCode(String employeeId) {
        return qrCodeUtil.generateQRCode(employeeId);
    }

    public void processQRCodeData(String qrCodeData) {
        attendanceService.registerAttendanceFromQRCode(qrCodeData);
    }
}