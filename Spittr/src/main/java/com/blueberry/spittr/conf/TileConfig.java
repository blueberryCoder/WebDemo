package com.blueberry.spittr.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * Created by Administrator on 11/15/2016.
 */
@Component
@Configuration
public class TileConfig {
    @Bean
    public ViewResolver viewResolver(){
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        return tilesViewResolver;
    }
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tiles = new TilesConfigurer();
        //指定Tile定义的位置
        tiles.setDefinitions(new String[]{
                "/WEB-INF/layout/tiles.xml"
        });
        tiles.setCheckRefresh(true); //启用刷新功能
        return tiles;
    }
}
