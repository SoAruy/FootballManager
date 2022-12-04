package ua.solyha.footballmanager.dto;

import org.springframework.hateoas.RepresentationModel;

public class PlayerListDto extends RepresentationModel<PlayerListDto> {
    private String name;

    public PlayerListDto() {
    }

    public PlayerListDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
