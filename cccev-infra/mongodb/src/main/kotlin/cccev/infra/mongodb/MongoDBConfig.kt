package cccev.infra.mongodb

import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper
import org.springframework.data.mongodb.core.convert.MappingMongoConverter

@Configuration
class MongoDBConfig: InitializingBean {

    @Autowired
    private val mappingMongoConverter: MappingMongoConverter? = null

    @Throws(Exception::class)
    override fun afterPropertiesSet() {
        mappingMongoConverter!!.setTypeMapper(DefaultMongoTypeMapper(null))
    }
}
