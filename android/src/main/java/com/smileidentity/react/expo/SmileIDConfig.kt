package com.smileidentity.react.expo

import expo.modules.kotlin.records.Field
import expo.modules.kotlin.records.Record

data class SmileIDConfig(
    @Field val partnerId: String,
    @Field val authToken: String,
    @Field val prodLambdaUrl: String,
    @Field val testLambdaUrl: String
) : Record
