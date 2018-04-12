package org.gleason;
import javax.persistence.*;

@Entity
@Table(name="ADDRESS", schema="MAIN")
public class AddressDomain{
	@Column(name="ID")
	@Id
	private String id;
	@Column(name="CITY")
	private String city;

	public String getCity(){return city;}
}