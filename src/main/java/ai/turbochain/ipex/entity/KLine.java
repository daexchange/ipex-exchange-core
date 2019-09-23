package ai.turbochain.ipex.entity;


import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class KLine implements Serializable{
	
	private static final long serialVersionUID = 6419130857778552302L;
	
	public KLine(){

    }
    public KLine(String period){
        this.period = period;
    }
    private BigDecimal openPrice = BigDecimal.ZERO;
    private BigDecimal highestPrice  = BigDecimal.ZERO;
    private BigDecimal lowestPrice  = BigDecimal.ZERO;
    private BigDecimal closePrice  = BigDecimal.ZERO;
    private long time;
    private String period;

    /**
     * 	成交笔数
     */
    private int count;
    /**
     *	 成交量
     */
    private BigDecimal volume = BigDecimal.ZERO;
    /**
     *	 成交额
     */
    private BigDecimal turnover = BigDecimal.ZERO;
}
