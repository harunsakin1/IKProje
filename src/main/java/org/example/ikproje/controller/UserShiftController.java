package org.example.ikproje.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.ikproje.dto.request.AssignShiftToUserRequestDto;
import org.example.ikproje.dto.response.BaseResponse;
import org.example.ikproje.dto.response.UserShiftResponseDto;
import org.example.ikproje.entity.Shift;
import org.example.ikproje.entity.User;
import org.example.ikproje.entity.UserShift;
import org.example.ikproje.service.UserShiftService;
import org.example.ikproje.view.VwUserActiveShift;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.example.ikproje.constant.RestApis.*;


@RestController
@RequestMapping(USERSHIFT)
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserShiftController {
	private final UserShiftService userShiftService;
	
	@PostMapping(ASSIGN_SHIFT_TO_USER)
	public ResponseEntity<BaseResponse<Boolean>> assignShiftToUser(@RequestBody @Valid AssignShiftToUserRequestDto dto){
		return ResponseEntity.ok(BaseResponse.<Boolean>builder()
				                         .code(200)
				                         .message("Personele vardiya ataması başarılı.")
				                         .success(true)
				                         .data(userShiftService.assignShiftToUser(dto))
		                                     .build());
	}
	
	@GetMapping(GET_ACTIVE_SHIFT_DETAILS)
	public ResponseEntity<BaseResponse<VwUserActiveShift>> getActiveShiftDetails(@RequestParam Long userId,@RequestParam String token){
		return ResponseEntity.ok(BaseResponse.<VwUserActiveShift>builder()
				                         .code(200)
				                         .message("Personelin vardiya ve mola bilgileri getirildi.")
				                         .success(true)
				                         .data(userShiftService.getActiveShiftDetailsByUserId(userId,token))
		                                     .build());
	}

	//Şirkete ait personelleri getirir.
	@GetMapping("/get-personel-list-by-companyId")
	public ResponseEntity<BaseResponse<List<User>>> getPersonelListByCompanyId(@RequestParam String token){
		return ResponseEntity.ok(BaseResponse.<List<User>>builder()
						.code(200)
						.message("Personel Listesi Başarıyla Getirildi.")
						.success(true)
						.data(userShiftService.getPersonelListByCompanyId(token))
				.build());
	}

	//Şirket Yöneticisi tarafından personele atanmış vardiya listesini döndürür.
	@GetMapping("/get-personel-shift-list")
	public ResponseEntity<BaseResponse<List<UserShiftResponseDto>>> getGetPersonelShiftList(@RequestParam String token){
		return ResponseEntity.ok(BaseResponse.<List<UserShiftResponseDto>>builder()
						.code(200)
						.message("Personellere atanmış vardiya listesi başarıyla getirildi.")
						.success(true)
						.data(userShiftService.getPersonelShiftList(token))
				.build());
	}
}