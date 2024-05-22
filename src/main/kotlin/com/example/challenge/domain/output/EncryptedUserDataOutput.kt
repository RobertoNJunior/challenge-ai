package com.example.challenge.domain.output

data class EncryptedUserDataOutput(
    val encryptData: String
) {
    companion object {
        fun of(encryptData: String): EncryptedUserDataOutput {
            return EncryptedUserDataOutput(
                encryptData = encryptData
            )
        }
    }
}
