package com.indir.monitoring.api.exception.error

class BadRequestException(val error: RestApiError) : RuntimeException()