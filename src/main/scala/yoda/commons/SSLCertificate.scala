/*
 * Copyright (c) 2020. Peerapat Asoktummarungsri <https://www.linkedin.com/in/peerapat>
 */

package yoda.commons

import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl._

trait SSLCertificate {

  def trustAllCert(): Unit = {

    import javax.net.ssl.SSLSession

    val trustAllCerts = Array[TrustManager](new X509TrustManager {

      override def checkServerTrusted(x509Certificates: Array[X509Certificate], s: String): Unit = {}

      override def checkClientTrusted(x509Certificates: Array[X509Certificate], s: String): Unit = {}

      override def getAcceptedIssuers: Array[X509Certificate] = Array.empty

    })

    val sc = SSLContext.getInstance("SSL")
    sc.init(null, trustAllCerts, new SecureRandom)
    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory)

    // Create all-trusting host name verifier
    val allHostsValid = new HostnameVerifier {
      override def verify(hostname: String, session: SSLSession) = true
    }

    // Install the all-trusting host verifier
    HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid)
  }

}
