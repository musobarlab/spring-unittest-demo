.PHONY : test build clean format package

include .env
$(eval export $(cat .env | sed 's/#.*//g' | xargs))

package:
	mvn clean package
