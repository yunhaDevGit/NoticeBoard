package com.toyproject.noticeboard.auth;

import com.toyproject.noticeboard.model.UserInfo;
import java.util.ArrayList;
import java.util.Collection;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
public class PrincipalDetails implements UserDetails {

  private UserInfo userInfo;

  public PrincipalDetails(UserInfo userInfo) {
    this.userInfo = userInfo;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<GrantedAuthority> collection = new ArrayList<>();
    collection.add(new GrantedAuthority() {
      @Override
      public String getAuthority() {
        return String.valueOf(userInfo.getRole());
      }
    });
    return collection;
  }

  @Override
  public String getPassword() {
    return userInfo.getPassword();
  }

  @Override
  public String getUsername() {
    return userInfo.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
