package com.example.server.common.sys;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class UserVo implements UserDetails  {
	
	private String userId;
	    
    private String userPw;
    
    private String userRole;
	
    private String id;


    private String pw;

    private String roles;
    
    private PasswordEncoder passwordEncoder;


    private String adminId;
	private String adminNm;
	private String adminPw;
	private String pwExpireDate;
	private String email;
	private String adminMobileCd;
	private String phoneNo1;
	private String phoneNo2;
	private String phoneNo3;
	private String phoneNoFullNumber;	//phoneNo1+phoneNo2+phoneNo3
	private String conIp;
	private String deviceNmVer;
	private String loginDt;
	private String adminStatusCd;
	private String adminStatusCdNm;
	private String lastPwChangeDate;
	private String connectionYn;
	private String passwordChangeAlarm;
	private String adminPassWordStatus;
	private int timeStampDiff;
    
    

    public UserVo() {}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

    

}

