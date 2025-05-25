package com.gym.management.common.model.user.entity

import com.gym.management.common.model.user.dto.UserDTO
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnDefault
import java.time.LocalDateTime

@Entity
@Table(name = "\"user\"")
class User(
    @Id
    @Size(max = 20)
    @Column(name = "user_id", nullable = false, length = 20)
    val userId: String,

    @Size(max = 30)
    @NotNull
    @Column(name = "user_password", nullable = false, length = 30)
    val userPassword: String,

    @Size(max = 5)
    @NotNull
    @Column(name = "user_role", nullable = false, length = 5)
    val userRole: String,

    @Size(max = 10)
    @NotNull
    @Column(name = "user_name", nullable = false, length = 10)
    val userName: String,

    @Size(max = 20)
    @NotNull
    @Column(name = "user_phone", nullable = false, length = 20)
    val userPhone: String,

    @Size(max = 30)
    @Column(name = "user_email", length = 30)
    val userEmail: String? = null,

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "user_created_at", nullable = false)
    val userCreatedAt: LocalDateTime,

    @NotNull
    @Column(name = "user_updated_at", nullable = false)
    val userUpdatedAt: LocalDateTime,

    @NotNull
    @ColumnDefault("false")
    @Column(name = "user_deleted", nullable = false)
    val userDeleted: Boolean = false
) {
    constructor(userDTO: UserDTO) : this(
        userId = userDTO.userId,
        userPassword = userDTO.userPassword,
        userRole = userDTO.userRole,
        userName = userDTO.userName,
        userPhone = userDTO.userPhone,
        userEmail = userDTO.userEmail,
        userCreatedAt = userDTO.userCreatedAt,
        userUpdatedAt = userDTO.userUpdatedAt,
        userDeleted = userDTO.userDeleted
    )
}