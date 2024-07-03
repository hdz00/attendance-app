package com.attendanceapp.controller;

import com.attendanceapp.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qrcode")
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    @GetMapping("/generate/{employeeId}")
    public ResponseEntity<byte[]> generateQRCode(@PathVariable String employeeId) {
        byte[] qrCodeImage = qrCodeService.generateQRCode(employeeId);
        return ResponseEntity.ok()
                .header("Content-Type", "image/png")
                .body(qrCodeImage);
    }

    @PostMapping("/scan")
    public ResponseEntity<Void> scanQRCode(@RequestBody String qrCodeData) {
        qrCodeService.processQRCodeData(qrCodeData);
        return ResponseEntity.ok().build();
    }
}