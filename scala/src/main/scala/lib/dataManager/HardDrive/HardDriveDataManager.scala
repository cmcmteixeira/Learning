package lib.dataManager.HardDrive

import java.io._

import lib.dataManager.{DataManager, Resource}
import scaldi.{Injectable, Injector}

import scala.reflect.ClassTag

/**
  * TODO: Plz optimize access to data
  * @tparam T
  */
class HardDriveDataManager[T <: Resource with Serializable : ClassTag ](implicit inj: Injector) extends DataManager[T] with Injectable {
  val baseDir = inject[String](identified by 'baseDir)
  val fileName= inject[String](identified by 'fileName)

  private def save(resources: Seq[T]): Unit = {
    val file = new File(s"$baseDir/$fileName")
    file.getParentFile.mkdirs()
    file.createNewFile()
    val os = new ObjectOutputStream(new FileOutputStream(file,false))
    os.writeObject(resources.toArray)
    os.close()
  }
  private def loadResources():Seq[T]= {
    try {
      val is = new ObjectInputStream(new FileInputStream(s"$baseDir/$fileName"))
      val obj = is.readObject().asInstanceOf[Array[T]]
      is.close()
      return obj
    } catch {
      case a : Throwable => println(a)
    }
    Seq.empty[T]
  }
  override def createResource(resource: T): Option[T] = {
    val resources = loadResources() :+ resource
    save(resources)
    Option(resource)
  }

  override def readResource(seqFilter: (T) => Boolean): Seq[T] = loadResources filter seqFilter

  override def updateResource(oldR: T, newR: T): Option[T] = {
    save ((loadResources filter (_ == oldR)) :+ newR)
    Option(newR)
  }

  override def deleteResource(res: T): Option[T] = {
    save (loadResources filter (_ == res))
    Option(res)
  }
}
