package in.kaifee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue
	private Integer pid;
	@NotBlank(message = "Name is Mandatory")
	private String name;
	@NotNull(message = "Price is Mandatory")
	private Double price;
	@NotNull(message = "Quantiy is Mandatory")
	private Integer qty; 

}
