package com.app.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewUserProfile {
   private String firstName;
   private String lastName;
   private String email;
   private String password;
   private String birthMonth;
   private String birthDay;
}
