package ai.turbochain.ipex.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ExchangeCoinSettlement {
     
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String symbol;
    //状态，1：启用，0：禁止
    private int enable;
    //排序，从小到大
    private int sort;
}
