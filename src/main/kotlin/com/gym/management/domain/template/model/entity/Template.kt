package com.gym.management.domain.template.model.entity

import com.gym.management.domain.template.model.dto.TemplateDTO
import com.gym.management.domain.template.model.entity.id.TemplateId
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnDefault
import java.time.LocalDateTime

@IdClass(TemplateId::class)
@Entity
@Table(name = "gym_template")
class Template(
    @Id
    @NotNull
    @ColumnDefault("0")
    @Column(name = "branch_id", nullable = false)
    val branchId: Int,

    @Id
    @Size(max = 20)
    @NotNull
    @Column(name = "template_code", nullable = false, length = 20)
    val templateCode: String,

    @Size(max = 100)
    @NotNull
    @Column(name = "template_name", nullable = false, length = 100)
    val templateName: String,

    @NotNull
    @Column(name = "template_priority", nullable = false)
    val templatePriority: Int,

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "template_start_at", nullable = false)
    val templateStartAt: LocalDateTime = LocalDateTime.now(),

    @NotNull
    @ColumnDefault("(CURRENT_TIMESTAMP + '100 years')")
    @Column(name = "template_end_at", nullable = false)
    val templateEndAt: LocalDateTime = LocalDateTime.now().withYear(100),

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "template_created_at", nullable = false)
    val templateCreatedAt: LocalDateTime = LocalDateTime.now(),

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "template_updated_at", nullable = false)
    val templateUpdatedAt: LocalDateTime = LocalDateTime.now(),

    @NotNull
    @ColumnDefault("'N'")
    @Column(name = "template_deleted", nullable = false, length = Integer.MAX_VALUE)
    val templateDeleted: Char = 'N',
) {
    constructor(templateDTO: TemplateDTO) : this(
        branchId = templateDTO.branchId,
        templateCode = templateDTO.templateCode,
        templateName = templateDTO.templateName,
        templatePriority = templateDTO.templatePriority,
        templateStartAt = templateDTO.templateStartAt,
        templateEndAt = templateDTO.templateEndAt,
        templateCreatedAt = LocalDateTime.now(),
        templateUpdatedAt = LocalDateTime.now(),
        templateDeleted = 'N',
    )
}