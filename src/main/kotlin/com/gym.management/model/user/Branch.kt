package com.gym.management.model.user

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnDefault
import java.time.LocalDateTime

@Entity
@Table(name = "branch")
class Branch(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "branch_id_gen")
    @SequenceGenerator(name = "branch_id_gen", sequenceName = "branch_branch_id_seq", allocationSize = 50)
    @Column(name = "branch_id", nullable = false)
    var id: Int? = null,

    @Size(max = 20)
    @NotNull
    @Column(name = "branch_name", nullable = false, length = 20)
    var branchName: String? = null,

    @Size(max = 100)
    @NotNull
    @Column(name = "branch_address", nullable = false, length = 100)
    var branchAddress: String? = null,

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "branch_created_at", nullable = false)
    var branchCreatedAt: LocalDateTime? = null,

    @NotNull
    @Column(name = "branch_updated_at", nullable = false)
    var branchUpdatedAt: LocalDateTime? = null,

    @NotNull
    @ColumnDefault("false")
    @Column(name = "branch_deleted", nullable = false)
    var branchDeleted: Boolean? = false
)