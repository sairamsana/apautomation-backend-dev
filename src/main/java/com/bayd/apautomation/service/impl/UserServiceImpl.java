package com.bayd.apautomation.service.impl;


import com.bayd.apautomation.dto.UserDto;
import com.bayd.apautomation.entity.User;
import com.bayd.apautomation.enums.Status;
import com.bayd.apautomation.exception.CustomResourceNotFoundException;
import com.bayd.apautomation.mapper.UserMapper;
import com.bayd.apautomation.repository.UserRepo;
import com.bayd.apautomation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper = UserMapper.INSTANCE;
//    private final PasswordEncoder passwordEncoder;

    public Optional<UserDto> save(UserDto userDto, UUID userUUID) {
        if (Objects.isNull(userDto) || Objects.isNull(userDto.getMobile()) || Objects.isNull(userDto.getEmail()) || userDto.getMobile().isEmpty() || userDto.getEmail().isEmpty()) {
            return Optional.empty();
        }

        if (Objects.nonNull(userDto.getMobile())) {
            Optional<User> byEmail = userRepo.findByEmail(userDto.getEmail());
            if (byEmail.isPresent()) {
                throw new CustomResourceNotFoundException("Email alraedy exists");
            }
        }

        User user = userMapper.convertEntity(userDto);
        userMapper.prepareForCreate(user);
        user.setPassword(user.getPassword());
        User save = userRepo.save(user);

        save.setPassword(null);
        return Optional.ofNullable(userMapper.convertDto(save));
    }

    public Optional<UserDto> saved(UserDto userDto) {
        if (Objects.isNull(userDto) || Objects.isNull(userDto.getMobile()) || Objects.isNull(userDto.getEmail()) || userDto.getMobile().isEmpty() || userDto.getEmail().isEmpty()) {
            return Optional.empty();
        }

        if (Objects.nonNull(userDto.getEmail())) {
            Optional<User> byEmail = userRepo.findByEmail(userDto.getEmail());
            if (byEmail.isPresent()) {
                throw new CustomResourceNotFoundException("Email alraedy exists");
            }
        }

        User user = userMapper.convertEntity(userDto);
        userMapper.prepareForCreate(user);
        user.setPassword(user.getPassword());
        User save = userRepo.save(user);

        save.setPassword(null);
        return Optional.ofNullable(userMapper.convertDto(user));
    }

    @Override
    public Optional<UserDto> get(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public Status delete(UUID uuid) {
        return null;
    }

    @Override
    public Optional<UserDto> login(UserDto userDto) {
        return Optional.empty();
    }



/*
    @Override
    public Optional<UserDto> login(UserDto userDto) {
        if (Objects.nonNull(userDto)) {
            Optional<User> byUserName = userRepo.findByMobileNumberOrEmail(userDto.getMobileNumber(), userDto.getEmail());
            if (byUserName.isPresent()) {
                User user = byUserName.get();
                if (Objects.nonNull(userDto.getPassword()) && passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
                    UserDto convertDto = userMapper.convertDto(user);
                    convertDto.setPassword(null);
                    return Optional.of(convertDto);
                }
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<UserDto> get(UUID userId) {
        if (Objects.nonNull(userId)) {
            Optional<User> byUserId = userRepo.findById(userId);
            if (byUserId.isPresent()) {
                User user = byUserId.get();
                UserDto convertDto = userMapper.convertDto(user);
                convertDto.setPassword(null);
                return Optional.of(convertDto);
            }
        }
        return Optional.empty();
    }

    @Override
    public Status delete(UUID uuid) {
        return null;
    }




    private Date getExpireTime() {
        Date expiration = new Date();
        long expTimeMillis = expiration.getTime();
        expTimeMillis += 1000 * 60 * 60 * 2;
        expiration.setTime(expTimeMillis);
        return expiration;
    }*/

   /* @Override
    public Optional<UserDto> changePassword(ChangePasswordDto changePasswordDto, UUID userId) {
        Optional<User> optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(changePasswordDto.getOldPassword(), user.getPassword()) && changePasswordDto.getNewPassword().equals(changePasswordDto.getConfirmNewPassword())) {
                user.setPassword(passwordEncoder.encode(changePasswordDto.getNewPassword()));
                user = userRepo.save(user);
                user.setPassword(null);
                return Optional.of(userMapper.convertDto(user));
            }
        }
        return Optional.empty();
    }
*/


}
