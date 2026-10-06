package com.edu.edusolution.controller;

import com.edu.edusolution.dto.request.spin.*;
import com.edu.edusolution.dto.response.spin.*;
import com.edu.edusolution.service.SpinService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/spin")
@RequiredArgsConstructor
public class SpinController {

    private final SpinService spinService;

    @PostMapping("/play/{browserId}")
    public ResponseEntity<SpinPrizeResponseDTO> playSpin(@PathVariable UUID browserId, HttpServletRequest request){
        String ip = request.getRemoteAddr();

        return ResponseEntity.status(HttpStatus.OK).body(spinService.playSpin(new SpinPlayRequestDTO(browserId)));
    }

    @PostMapping("/check")
    public ResponseEntity<SpinCheckResponseDTO> checkPlayer(@RequestBody @Valid SpinCheckRequestDTO request) {
        return ResponseEntity.ok(spinService.spinEligibilityCheck(request));
    }

    @PostMapping("/send")
    public ResponseEntity<PrizeSendResponseDTO> sendPrize(@RequestBody @Valid PrizeSendRequestDTO request) {
        return ResponseEntity.ok(spinService.sendPrize(request));
    }

    @PostMapping("/add_prize")
    public ResponseEntity<PrizeAddResponseDTO> addPrize(@RequestBody @Valid PrizeAddRequestDTO request) {
        return ResponseEntity.ok(spinService.addPrizeToSpin(request));
    }

    @DeleteMapping("/delete_prize/{prizeName}")
    public ResponseEntity<PrizeDeleteResponseDTO> deletePrize(@PathVariable String prizeName) {
        return ResponseEntity.status(HttpStatus.OK).body(spinService.deletePrize(prizeName));
    }

    @GetMapping("/prizes")
    public ResponseEntity<List<PrizesResponseDTO>> getAllPrizes() {
        return ResponseEntity.ok(spinService.getPrizes());
    }

    @PatchMapping("/update")
    public ResponseEntity<List<PrizeUpdateResponseDTO>> updatePrizes(@RequestBody @Valid List<PrizeUpdateRequestDTO> request) {
        return ResponseEntity.ok(spinService.updatePrizes(request));
    }

    @GetMapping("/winners")
    public ResponseEntity<List<SpinWinnersDTO>> getWinners() {
        return ResponseEntity.ok(spinService.spinWinners());
    }
}
