package com.github.aerialist7

import kotlinx.js.JsPlainObject

@JsPlainObject
sealed external interface CreateWorldTerrainAsyncOptions {
    var requestVertexNormals: Boolean?
    var requestWaterMask: Boolean?
}
