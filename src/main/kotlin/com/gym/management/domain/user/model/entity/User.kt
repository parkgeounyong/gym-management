package com.gym.management.domain.user.model.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.Comment
import java.time.LocalDateTime

@Entity
@Table(name = "gym_user")
class User(
    @Id
    @Size(max = 20)
    @Column(name = "user_id", nullable = false, length = 20)
    val userId: String,

    @Size(max = 200)
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
    var userName: String,

    @Size(max = 20)
    @NotNull
    @Column(name = "user_phone", nullable = false, length = 20)
    var userPhone: String,

    @Size(max = 30)
    @Column(name = "user_email", length = 30)
    var userEmail: String? = null,

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "user_created_at", nullable = false)
    val userCreatedAt: LocalDateTime = LocalDateTime.now(),

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "user_updated_at", nullable = false)
    var userUpdatedAt: LocalDateTime = LocalDateTime.now(),

    @NotNull
    @ColumnDefault("'N'")
    @Column(name = "user_deleted", nullable = false)
    @Comment("삭제 여부, 'Y'는 삭제됨, 'N'은 사용 중")
    val userDeleted: Char = 'N',
)