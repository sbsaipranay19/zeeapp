package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "episode")
public class Episodes {

	public Episodes() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "episodeId")
	private String episodeId;
	@NotBlank
	private String episodeName;
	@NotNull
	private double episodeLength;
	@NotBlank
	private String location;
	@NotBlank
	private String trailer;
	@NotBlank
	private String seriesId;

}
