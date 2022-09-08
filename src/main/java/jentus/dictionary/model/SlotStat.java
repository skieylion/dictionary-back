package jentus.dictionary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
public class SlotStat {
    private Long slotId;
    private int overdueCount;
    private int waitingCount;
    private int studiedCount;
    private int totalCount;
}
