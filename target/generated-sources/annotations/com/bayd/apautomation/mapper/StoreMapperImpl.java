package com.bayd.apautomation.mapper;

import com.bayd.apautomation.dto.StoreDTO;
import com.bayd.apautomation.entity.Store;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-23T19:32:40-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_351 (Oracle Corporation)"
)
public class StoreMapperImpl implements StoreMapper {

    @Override
    public Store convertEntity(StoreDTO s) {
        if ( s == null ) {
            return null;
        }

        Store store = new Store();

        store.setStoreid( s.getStoreid() );
        store.setName( s.getName() );

        return store;
    }

    @Override
    public StoreDTO convertDto(Store t) {
        if ( t == null ) {
            return null;
        }

        StoreDTO storeDTO = new StoreDTO();

        storeDTO.setStoreid( t.getStoreid() );
        storeDTO.setName( t.getName() );

        return storeDTO;
    }

    @Override
    public List<StoreDTO> convertDtos(List<Store> tList) {
        if ( tList == null ) {
            return null;
        }

        List<StoreDTO> list = new ArrayList<StoreDTO>( tList.size() );
        for ( Store store : tList ) {
            list.add( convertDto( store ) );
        }

        return list;
    }

    @Override
    public List<Store> convertEntities(List<StoreDTO> sList) {
        if ( sList == null ) {
            return null;
        }

        List<Store> list = new ArrayList<Store>( sList.size() );
        for ( StoreDTO storeDTO : sList ) {
            list.add( convertEntity( storeDTO ) );
        }

        return list;
    }
}
