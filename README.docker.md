# Build com docker

Devido à complexidade de configurar uma SDK dedicada para compilar os pacotes para o target, foi decidido utilizar um container `docker` para compilar os pacotes do MOGBE no dispositivo. A estratégia então é compilar a imagem com Docker e utilizar os resultados de compilação.

# Passos para build

Dar fetch na imagem:

```bash
docker pull ros:humble
```

Rodar o terminal da imagem montando um volume na área de trabalho em `/mogbe/mogbe_ws`:

```bash
docker run --rm -it -v /mogbe/mogbe_ws:/workspace ros:humble bash
```

Dentro do terminal da imagem, instalar pacotes dev da `libboost`:

```bash
apt-get update
```

```bash
apt-get install -y libboost-all-dev
```

Configurar as variáveis de ambiente ROS 2 (se já não configuradas):

```bash
source /opt/ros/humble/setup.bash
```

Mudar para a área de trabalho:

```bash
cd /workspace
```

> Solução temporária para o problema do `gazebo` não estar disponível:
> 
> `sed -i '/<depend>gazebo_ros_pkgs<\/depend>/d;/<depend>gazebo_ros2_control<\/depend>/d' src/mogbe/package.xml`
> 
> `sed -i '/<depend>gazebo_ros_pkgs<\/depend>/d' src/mogbe/package.xml`

Instalar dependências:

```bash
rosdep init
```

```bash
rosdep update && rosdep install --from-paths src -y --ignore-src
```

Compilar projetos:

```bash
colcon build --symlink-install
```