package com.player.model;

import lombok.*;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "secret_code")
	private String secretCode;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "date_created")
    private Timestamp sqlTimestamp;

	private double requiredAmount;
	private  double totalAmount;
	private double paidAmount;
	private double outstandingAmount;
	private double seasonRequiredAmount;


//	@OneToMany(mappedBy = "player",cascade = CascadeType.ALL)
//	private List <FinancialStatement> financialStatements;
//
//	public List<FinancialStatement> getFinancialStatements() {
//		return financialStatements;
//	}
//
//	public void setFinancialStatements(List<FinancialStatement> financialStatements) {
//		this.financialStatements = financialStatements;
//
//		for (FinancialStatement financialStatement : financialStatements) {
//			financialStatement.setPlayer(this);
//
//		}
//	}
}
