package jentus.dictionary.model.dto;

import jentus.dictionary.model.SlotStat;
import lombok.Data;

@Data
public class SlotDto {
    private long id;
    private String name;
    private String description;
    private String fileId;
    private SlotStat slotStat;
}
