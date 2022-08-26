package com.example.open_meteo_download.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.open_meteo_download.entity.OpenMeteoHistory;
import com.example.open_meteo_download.response.OpenMeteoResponse;

@EnableJpaRepositories
@Repository
public interface OpenMeteoHistoryRepository
        extends JpaRepository<OpenMeteoHistory, Long> {
    /**
     * 登録済みIDの最大値を取得
     * @return 登録済みIDの最大値
     */
    @Query(value = "select max(id) from open_meteo_history", nativeQuery = true)
    public Long getMaxId();

    /**
     * OpenMeteoのレスポンスを保存
     * @param id 連番
     * @param response レスポンス
     */
    @Query(value = "insert into open_meteo_history(id, response) values(:id, :response)", nativeQuery = true)
    public void save(@Param("id") Long id, @Param("response") OpenMeteoResponse response);

    /**
     * レスポンスの日時データのみ取得
     * 
     * @return 日時データ
     */
    @Query(value = "select * from open_meteo_history order by id desc limit 1", nativeQuery = true)
    public OpenMeteoHistory selectLastData();

}
