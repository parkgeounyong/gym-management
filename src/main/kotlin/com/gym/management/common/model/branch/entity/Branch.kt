package com.gym.management.common.model.branch.entity

import com.gym.management.common.model.branch.dto.BranchDTO
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
    val id: Int = 0,

    @Size(max = 20)
    @NotNull
    @Column(name = "branch_name", nullable = false, length = 20)
    val branchName: String,

    @Size(max = 100)
    @NotNull
    @Column(name = "branch_address", nullable = false, length = 100)
    val branchAddress: String,

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "branch_created_at", nullable = false)
    val branchCreatedAt: LocalDateTime,

    @NotNull
    @Column(name = "branch_updated_at", nullable = false)
    val branchUpdatedAt: LocalDateTime,

    @NotNull
    @ColumnDefault("false")
    @Column(name = "branch_deleted", nullable = false)
    val branchDeleted: Boolean = false
) {
    constructor(branchDTO: BranchDTO) : this(
        branchName = branchDTO.branchName,
        branchAddress = branchDTO.branchAddress,
        branchCreatedAt = branchDTO.branchCreatedAt,
        branchUpdatedAt = branchDTO.branchUpdatedAt,
        branchDeleted = false
    )
}