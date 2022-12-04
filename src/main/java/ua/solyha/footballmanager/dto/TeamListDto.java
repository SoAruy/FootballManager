package ua.solyha.footballmanager.dto;

import org.springframework.hateoas.RepresentationModel;

public class TeamListDto extends RepresentationModel<TeamListDto> {
    private String name;

    public TeamListDto(String name) {
        this.name = name;
    }

    public TeamListDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
