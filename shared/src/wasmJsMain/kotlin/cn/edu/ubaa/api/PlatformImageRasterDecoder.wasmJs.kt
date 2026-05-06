package cn.edu.ubaa.api.plantform

import cn.edu.ubaa.api.plantform.LocalCgyyImageData

internal actual object PlatformImageRasterDecoder {
  actual fun decode(input: ByteArray): LocalCgyyImageData =
      error("Image decode is unsupported on Wasm local CGYY runtime")
}
