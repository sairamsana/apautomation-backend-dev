package com.bayd.apautomation.mapper;

import com.bayd.apautomation.dto.UserDto;
import com.bayd.apautomation.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-05T19:18:16-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_351 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User convertEntity(UserDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.userid( arg0.getUserid() );
        user.firstname( arg0.getFirstname() );
        user.lastname( arg0.getLastname() );
        user.password( arg0.getPassword() );
        user.email( arg0.getEmail() );
        user.mobile( arg0.getMobile() );
        user.isverified( arg0.getIsverified() );

        return user.build();
    }

    @Override
    public UserDto convertDto(User arg0) {
        if ( arg0 == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUserid( arg0.getUserid() );
        userDto.setFirstname( arg0.getFirstname() );
        userDto.setLastname( arg0.getLastname() );
        userDto.setPassword( arg0.getPassword() );
        userDto.setEmail( arg0.getEmail() );
        userDto.setMobile( arg0.getMobile() );
        userDto.setIsverified( arg0.getIsverified() );

        return userDto;
    }

    @Override
    public List<UserDto> convertDtos(List<User> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( arg0.size() );
        for ( User user : arg0 ) {
            list.add( convertDto( user ) );
        }

        return list;
    }

    @Override
    public List<User> convertEntities(List<UserDto> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( arg0.size() );
        for ( UserDto userDto : arg0 ) {
            list.add( convertEntity( userDto ) );
        }

        return list;
    }
}
