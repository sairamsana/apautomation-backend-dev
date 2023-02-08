package com.bayd.apautomation.mapper;

import com.bayd.apautomation.dto.UserDto;
import com.bayd.apautomation.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-07T21:36:09-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_351 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User convertEntity(UserDto s) {
        if ( s == null ) {
            return null;
        }

        User user = new User();

        user.setUserid( s.getUserid() );
        user.setFirstname( s.getFirstname() );
        user.setLastname( s.getLastname() );
        user.setPassword( s.getPassword() );
        user.setEmail( s.getEmail() );
        user.setMobile( s.getMobile() );
        user.setIsverified( s.getIsverified() );

        return user;
    }

    @Override
    public UserDto convertDto(User t) {
        if ( t == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUserid( t.getUserid() );
        userDto.setFirstname( t.getFirstname() );
        userDto.setLastname( t.getLastname() );
        userDto.setPassword( t.getPassword() );
        userDto.setEmail( t.getEmail() );
        userDto.setMobile( t.getMobile() );
        userDto.setIsverified( t.getIsverified() );

        return userDto;
    }

    @Override
    public List<UserDto> convertDtos(List<User> tList) {
        if ( tList == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( tList.size() );
        for ( User user : tList ) {
            list.add( convertDto( user ) );
        }

        return list;
    }

    @Override
    public List<User> convertEntities(List<UserDto> sList) {
        if ( sList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( sList.size() );
        for ( UserDto userDto : sList ) {
            list.add( convertEntity( userDto ) );
        }

        return list;
    }
}
