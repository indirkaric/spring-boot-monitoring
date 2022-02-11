package com.indir.monitoring.api.exception.error

class NotFoundException(val error: RestApiError) : RuntimeException()