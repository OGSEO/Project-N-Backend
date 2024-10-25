package nl.gelton.projectnbackend.controller;

import lombok.RequiredArgsConstructor;
import nl.gelton.projectnbackend.dto.Response;
import nl.gelton.projectnbackend.dto.input.AddressInputDto;
import nl.gelton.projectnbackend.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/save")
    public ResponseEntity<Response> saveAndUpdateAddress(@RequestBody AddressInputDto addressInputDto) {
        return ResponseEntity.ok(addressService.saveAndUpdateAddress(addressInputDto));
    }
}
