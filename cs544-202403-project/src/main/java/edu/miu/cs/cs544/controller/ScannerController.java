package edu.miu.cs.cs544.controller;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.service.contract.MemberPayload;
import edu.miu.cs.cs544.service.contract.ScannerPayload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scanners")
public class ScannerController extends BaseReadWriteController<ScannerPayload, Scanner, Long> {

//        private final ScannerRecordService scannerRecordService;
//
//        @Autowired
//        public ScannerController(ScannerService scannerService, ScannerRecordService scannerRecordService) {
//            super(scannerService);
//            this.scannerRecordService = scannerRecordService;
//        }
//
//        @GetMapping("/{scannerCode}/records")
//        public <ScannerRecordPayload> List<ScannerRecordPayload> getScannerRecords(@PathVariable("scannerCode") String scannerCode) {
//            // Implement logic to retrieve scanner records for the specified scanner code
//            // You may need to fetch the scanner first and then fetch its records
//            // Convert the entities to payloads if necessary using the mapper
//            return scannerRecordService.getScannerRecordsByScannerCode(scannerCode);
//        }




}
