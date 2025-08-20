package com.gym.management.domain.branch.model.entity

import com.gym.management.domain.branch.model.dto.BranchDTO
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.Comment
import java.time.LocalDateTime

@Entity
@Table(name = "gym_branch")
class Branch(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "branch_id_gen")
    @SequenceGenerator(name = "branch_id_gen", sequenceName = "branch_branch_id_seq", allocationSize = 50)
    @Column(name = "branch_id", nullable = false)
    val branchId: Int = 0,

    @Size(max = 20)
    @NotNull
    @Column(name = "branch_name", nullable = false, length = 20)
    var branchName: String,

    @Size(max = 100)
    @NotNull
    @Column(name = "branch_address", nullable = false, length = 100)
    var branchAddress: String,

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "branch_created_at", nullable = false)
    val branchCreatedAt: LocalDateTime = LocalDateTime.now(),

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "branch_updated_at", nullable = false)
    var branchUpdatedAt: LocalDateTime = LocalDateTime.now(),

    @NotNull
    @ColumnDefault("'N'")
    @Column(name = "branch_deleted", nullable = false)
    @Comment("삭제 여부, 'Y'는 삭제됨, 'N'은 사용 중")
    val branchDeleted: Char = 'N',

    @NotNull
    @Column(name = "user_id", nullable = false, length = 20)
    var userId: String,

    @NotNull
    @Column(name = "branch_boss_user_id", nullable = false, length = 20)
    var branchBossUserId: String,
) {
    constructor(branchDTO: BranchDTO): this(
        branchName = branchDTO.branchName,
        branchAddress = branchDTO.branchAddress,
        branchCreatedAt = branchDTO.branchCreatedAt,
        branchUpdatedAt = branchDTO.branchUpdatedAt,
        userId = branchDTO.userId,
        branchBossUserId = branchDTO.branchBossUserId,
    )

    fun updateBy(branchDTO: BranchDTO): Branch{
        branchName = branchDTO.branchName
        branchAddress = branchDTO.branchAddress
        branchUpdatedAt = branchDTO.branchUpdatedAt
        userId = branchDTO.userId
        branchBossUserId = branchDTO.branchBossUserId
        return this
    }
}