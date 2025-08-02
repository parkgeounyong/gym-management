package com.gym.management.domain.template.model.entity.id

import java.io.Serializable


data class TemplateId(

    var branchId: Int? = null,

    var templateCode: String? = null
) : Serializable