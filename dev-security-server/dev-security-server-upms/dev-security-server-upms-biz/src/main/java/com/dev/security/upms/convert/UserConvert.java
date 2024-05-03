package com.dev.security.upms.convert;

import com.dev.security.upms.dto.UserDTO;
import com.dev.security.upms.entity.User;
import org.mapstruct.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * UserConvert
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-03
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserConvert {
    UserDTO entityToDto(User user);

    User toEntity(UserDTO userDTO);

    Set<User> toEntity(Set<UserDTO> userDTO);

    List<User> toEntity(List<UserDTO> userDTO);

    Collection<User> toEntity(Collection<UserDTO> userDTO);

    Set<UserDTO> toDTO(Set<User> user);

    List<UserDTO> toDTO(List<User> user);

    Collection<UserDTO> toDTO(Collection<User> user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserDTO userDTO, @MappingTarget User user);
}
