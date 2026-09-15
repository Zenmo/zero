package com.zenmo.vallum

import com.zenmo.zummon.companysurvey.Survey

/**
 * Get all BAG pand ID's in a list of surveys.
 * This result can be used to efficiently query the BAG for the geometry and metadata.
 * For example, using the library https://github.com/Zenmo/bag-client-java
 */
fun allPandIdsOfSurveys(surveys: List<Survey>): Set<String> = surveys
    .flatMap { it.allPandIds() }
    .map { it.value }
    .toSet()
