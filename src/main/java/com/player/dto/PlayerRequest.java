package com.player.dto;

import com.player.model.Player;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class PlayerRequest {

    private Player player;

}
