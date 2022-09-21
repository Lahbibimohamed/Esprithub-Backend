package tn.esprithub.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class RegistrationRequest {

	private  String  firstName;
    private  String  lastName;
    private  String  email;
    private  String  password;
    private   Gender gender;
    private   Long phone ;
    private    String address;
    private    String role;

}

