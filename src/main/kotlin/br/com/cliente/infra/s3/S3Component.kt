package br.com.cliente.infra.s3

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.PutObjectRequest
import com.amazonaws.util.IOUtils
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


@Component
class S3Component(
    @Value("\${amazonProperties.bucketName}")
    private val bucketName: String? = null,
    @Value("\${amazonProperties.region}")
    private val region: String? = null,
    private val s3Client: AmazonS3
) {

    fun uploadFile(file: MultipartFile): String {
        val fileName = System.currentTimeMillis().toString() + file.name
        s3Client.putObject(PutObjectRequest(bucketName, fileName, convertMultiPartToFile(file)))
        return "$bucketName.s3-website-$region.amazonaws.com/$fileName"
    }

    @Throws(IOException::class)
    private fun convertMultiPartToFile(file: MultipartFile): File? {
        val convFile = file.originalFilename?.let { File(it) }
        val fos = FileOutputStream(convFile)
        fos.write(file.bytes)
        fos.close()
        return convFile
    }

    fun downloadFile(fileName: String): ByteArray? {
        try {
            return IOUtils.toByteArray(s3Client.getObject(bucketName, fileName).objectContent)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }
}