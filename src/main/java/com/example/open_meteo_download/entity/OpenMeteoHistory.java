package com.example.open_meteo_download.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.example.open_meteo_download.response.OpenMeteoResponse;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Open-Meteo 履歴データ
 * 
 * @param id       連番
 * @param response jsonデータ
 */
@Data
@Entity
@Table(name = "open_meteo_history")
@AllArgsConstructor
@NoArgsConstructor
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class OpenMeteoHistory {
    @Id
    @Column(name = "id")
    private Long id;

    @Type(type = "jsonb")
    @Column(name = "response", columnDefinition = "jsonb")
    private OpenMeteoResponse response;
}
