package com.gym.management.model.user.entity

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
    var userId: String? = null,

    @Size(max = 30)
    @NotNull
    @Column(name = "user_password", nullable = false, length = 30)
    var userPassword: String? = null,

    @Size(max = 5)
    @NotNull
    @Column(name = "user_role", nullable = false, length = 5)
    var userRole: String? = null,

    @Size(max = 10)
    @NotNull
    @Column(name = "user_name", nullable = false, length = 10)
    var userName: String? = null,

    @Size(max = 20)
    @NotNull
    @Column(name = "user_phone", nullable = false, length = 20)
    var userPhone: String? = null,

    @Size(max = 30)
    @Column(name = "user_email", length = 30)
    var userEmail: String? = null,

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "user_created_at", nullable = false)
    var userCreatedAt: LocalDateTime? = null,

    @NotNull
    @Column(name = "user_updated_at", nullable = false)
    var userUpdatedAt: LocalDateTime? = null,

    @NotNull
    @ColumnDefault("false")
    @Column(name = "user_deleted", nullable = false)
    var userDeleted: Boolean? = false
)