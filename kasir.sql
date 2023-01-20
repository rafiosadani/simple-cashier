-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 10 Jun 2022 pada 11.09
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kasir`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `id_barang` int(11) NOT NULL,
  `kode_barang` varchar(256) NOT NULL,
  `kode_kategori` varchar(256) NOT NULL,
  `nama_barang` varchar(256) NOT NULL,
  `satuan` varchar(256) NOT NULL,
  `stok_barang` int(16) NOT NULL,
  `harga_barang` int(16) NOT NULL,
  `kode_supplier` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`id_barang`, `kode_barang`, `kode_kategori`, `nama_barang`, `satuan`, `stok_barang`, `harga_barang`, `kode_supplier`) VALUES
(1, 'BRG00001', 'KTR0001', 'Indomie Goreng Mie Instan', 'PCS', 85, 2500, 'SPL0002'),
(2, 'BRG00002', 'KTR0001', 'Indomie Ayam Bawang', 'PCS', 48, 2400, 'SPL0002'),
(3, 'BRG00003', 'KTR0001', 'Indomie Kari Ayam', 'PCS', 28, 2500, 'SPL0002'),
(4, 'BRG00004', 'KTR0002', 'Air Mineral Aqua', 'PCS', 50, 3500, 'SPL0001'),
(5, 'BRG00005', 'KTR0002', 'Coca-Cola', 'PCS', 26, 5000, 'SPL0001'),
(6, 'BRG00006', 'KTR0003', 'Rokok Gudang Garam Surya 12', 'PAK', 62, 20000, 'SPL0003'),
(7, 'BRG00007', 'KTR0003', 'Rokok Djarum Super 12', 'PAK', 54, 20000, 'SPL0003'),
(8, 'BRG00008', 'KTR0003', 'Rokok Dji Sam Soe Kretek 12', 'PAK', 34, 19500, 'SPL0003'),
(9, 'BRG00009', 'KTR0004', 'Pasta Gigi Pepsodent', 'PCS', 46, 5000, 'SPL0002'),
(10, 'BRG00010', 'KTR0004', 'Pasta Gigi Pepsodent Action Herbal 123', 'PCS', 38, 6000, 'SPL0002');

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_pembelian`
--

CREATE TABLE `detail_pembelian` (
  `id_detail_pembelian` int(11) NOT NULL,
  `kode_transaksi_pembelian` varchar(256) NOT NULL,
  `kode_barang` varchar(256) NOT NULL,
  `harga_barang` int(16) NOT NULL,
  `jumlah` int(16) NOT NULL,
  `total_harga` int(16) NOT NULL,
  `kode_supplier` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `detail_pembelian`
--

INSERT INTO `detail_pembelian` (`id_detail_pembelian`, `kode_transaksi_pembelian`, `kode_barang`, `harga_barang`, `jumlah`, `total_harga`, `kode_supplier`) VALUES
(1, 'TRSPB2022060900001', 'BRG00006', 20000, 10, 200000, 'SPL0003'),
(2, 'TRSPB2022060900001', 'BRG00009', 5000, 2, 10000, 'SPL0002'),
(3, 'TRSPB2022060900002', 'BRG00001', 2500, 10, 25000, 'SPL0002'),
(4, 'TRSPB2022060900002', 'BRG00009', 5000, 10, 50000, 'SPL0002'),
(5, 'TRSPB2022060900002', 'BRG00006', 20000, 2, 40000, 'SPL0003'),
(6, 'TRSPB2022060900003', 'BRG00004', 3500, 5, 17500, 'SPL0001'),
(7, 'TRSPB2022060900003', 'BRG00006', 20000, 3, 60000, 'SPL0003'),
(8, 'TRSPB2022060900003', 'BRG00007', 20000, 1, 20000, 'SPL0003'),
(9, 'TRSPB2022060900004', 'BRG00007', 20000, 8, 160000, 'SPL0003'),
(10, 'TRSPB2022060900004', 'BRG00008', 19500, 8, 156000, 'SPL0003'),
(11, 'TRSPB2022060900004', 'BRG00009', 5000, 7, 35000, 'SPL0002'),
(12, 'TRSPB2022060900005', 'BRG00002', 2400, 5, 12000, 'SPL0002'),
(13, 'TRSPB2022060900005', 'BRG00009', 5000, 2, 10000, 'SPL0002'),
(14, 'TRSPB2022061000001', 'BRG00004', 3500, 20, 70000, 'SPL0001'),
(15, 'TRSPB2022061000001', 'BRG00001', 2500, 50, 125000, 'SPL0002');

--
-- Trigger `detail_pembelian`
--
DELIMITER $$
CREATE TRIGGER `after_insert_detail_pembelian` AFTER INSERT ON `detail_pembelian` FOR EACH ROW BEGIN
	UPDATE barang SET barang.stok_barang = barang.stok_barang + new.jumlah
    WHERE barang.kode_barang = new.kode_barang;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_update_detail_pembelian` AFTER UPDATE ON `detail_pembelian` FOR EACH ROW BEGIN
	UPDATE barang SET barang.stok_barang = barang.stok_barang - old.jumlah + new.jumlah
    WHERE barang.kode_barang = new.kode_barang;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `before_delete_detail_pembelian` BEFORE DELETE ON `detail_pembelian` FOR EACH ROW BEGIN
	UPDATE barang SET barang.stok_barang = barang.stok_barang - old.jumlah
    WHERE barang.kode_barang = old.kode_barang;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_penjualan`
--

CREATE TABLE `detail_penjualan` (
  `id_detail_penjualan` int(11) NOT NULL,
  `kode_transaksi_penjualan` varchar(256) NOT NULL,
  `kode_barang` varchar(256) NOT NULL,
  `harga_barang` int(16) NOT NULL,
  `jumlah` int(16) NOT NULL,
  `total_harga` int(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `detail_penjualan`
--

INSERT INTO `detail_penjualan` (`id_detail_penjualan`, `kode_transaksi_penjualan`, `kode_barang`, `harga_barang`, `jumlah`, `total_harga`) VALUES
(2, 'TRSPJ2022060600001', 'BRG00006', 20000, 1, 20000),
(3, 'TRSPJ2022060700001', 'BRG00007', 20000, 2, 40000),
(4, 'TRSPJ2022060800001', 'BRG00006', 20000, 2, 40000),
(5, 'TRSPJ2022060800001', 'BRG00005', 5000, 2, 10000),
(6, 'TRSPJ2022060800002', 'BRG00008', 19500, 2, 39000),
(7, 'TRSPJ2022060900001', 'BRG00006', 20000, 2, 40000),
(8, 'TRSPJ2022060900002', 'BRG00005', 5000, 2, 10000),
(9, 'TRSPJ2022060900002', 'BRG00008', 19500, 1, 19500),
(10, 'TRSPJ2022060900003', 'BRG00005', 5000, 7, 35000),
(11, 'TRSPJ2022060900004', 'BRG00005', 5000, 2, 10000),
(12, 'TRSPJ2022060900004', 'BRG00003', 2500, 3, 7500),
(13, 'TRSPJ2022061000001', 'BRG00001', 2500, 5, 12500),
(14, 'TRSPJ2022061000001', 'BRG00004', 3500, 2, 7000);

--
-- Trigger `detail_penjualan`
--
DELIMITER $$
CREATE TRIGGER `after_insert_detail_penjualan` AFTER INSERT ON `detail_penjualan` FOR EACH ROW BEGIN
	UPDATE barang SET barang.stok_barang = barang.stok_barang - new.jumlah
    WHERE barang.kode_barang = new.kode_barang;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_update_detail_penjualan` AFTER UPDATE ON `detail_penjualan` FOR EACH ROW BEGIN
	UPDATE barang SET barang.stok_barang = barang.stok_barang + old.jumlah - new.jumlah
    WHERE barang.kode_barang = new.kode_barang;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `before_delete_detail_penjualan` BEFORE DELETE ON `detail_penjualan` FOR EACH ROW BEGIN
	UPDATE barang SET barang.stok_barang = barang.stok_barang + old.jumlah
    WHERE barang.kode_barang = old.kode_barang;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `kategori_barang`
--

CREATE TABLE `kategori_barang` (
  `id_kategori` int(11) NOT NULL,
  `kode_kategori` varchar(256) NOT NULL,
  `nama_kategori` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kategori_barang`
--

INSERT INTO `kategori_barang` (`id_kategori`, `kode_kategori`, `nama_kategori`) VALUES
(1, 'KTR0001', 'Makanan'),
(2, 'KTR0002', 'Minuman'),
(3, 'KTR0003', 'Rokok'),
(4, 'KTR0004', 'Larutan Basa');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pegawai`
--

CREATE TABLE `pegawai` (
  `id_pegawai` int(16) NOT NULL,
  `kode_pegawai` varchar(256) NOT NULL,
  `nama_pegawai` varchar(256) NOT NULL,
  `jenis_kelamin` enum('Laki-Laki','Perempuan') DEFAULT NULL,
  `alamat_pegawai` text NOT NULL,
  `no_telp_pegawai` varchar(30) NOT NULL,
  `username` varchar(256) NOT NULL,
  `password` varchar(256) NOT NULL,
  `id_role` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `kode_pegawai`, `nama_pegawai`, `jenis_kelamin`, `alamat_pegawai`, `no_telp_pegawai`, `username`, `password`, `id_role`) VALUES
(1, 'PGW0001', 'Joko Supriyanto', 'Laki-Laki', 'Malang, Jatim', '081235786543', 'admin', 'admin', 1),
(2, 'PGW0002', 'Heru Kuncoro', 'Laki-Laki', 'Malang', '085675545345', 'kasir', 'kasir', 2),
(3, 'PGW0003', 'Fadilla Wardinielsa', 'Perempuan', 'Surabaya', '081235645675', 'admin1', 'admin1', 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembelian`
--

CREATE TABLE `pembelian` (
  `id_pembelian` int(11) NOT NULL,
  `kode_transaksi_pembelian` varchar(256) NOT NULL,
  `tgl_pembelian` date NOT NULL,
  `jumlah_barang` int(16) NOT NULL,
  `total_harga` int(16) NOT NULL,
  `bayar` int(16) NOT NULL,
  `kembali` int(16) NOT NULL,
  `status_pembelian` enum('Lunas','Belum Lunas') NOT NULL,
  `kode_pegawai` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pembelian`
--

INSERT INTO `pembelian` (`id_pembelian`, `kode_transaksi_pembelian`, `tgl_pembelian`, `jumlah_barang`, `total_harga`, `bayar`, `kembali`, `status_pembelian`, `kode_pegawai`) VALUES
(1, 'TRSPB2022060900001', '2022-06-09', 12, 210000, 215000, 5000, 'Lunas', 'PGW0002'),
(2, 'TRSPB2022060900002', '2022-06-09', 22, 115000, 115000, 0, 'Lunas', 'PGW0002'),
(3, 'TRSPB2022060900003', '2022-06-09', 9, 97500, 100000, 2500, 'Lunas', 'PGW0003'),
(4, 'TRSPB2022060900004', '2022-06-09', 32, 526500, 526500, 0, 'Lunas', 'PGW0001'),
(7, 'TRSPB2022060900005', '2022-06-09', 7, 22000, 50000, 28000, 'Lunas', 'PGW0002'),
(8, 'TRSPB2022061000001', '2022-06-10', 70, 195000, 200000, 5000, 'Lunas', 'PGW0001');

-- --------------------------------------------------------

--
-- Struktur dari tabel `penjualan`
--

CREATE TABLE `penjualan` (
  `id_penjualan` int(11) NOT NULL,
  `kode_transaksi_penjualan` varchar(256) NOT NULL,
  `tgl_penjualan` date NOT NULL,
  `jumlah_barang` int(16) NOT NULL,
  `total_harga` int(16) NOT NULL,
  `bayar` int(16) NOT NULL,
  `kembali` int(16) NOT NULL,
  `status_penjualan` enum('Lunas','Belum Lunas') NOT NULL,
  `kode_pegawai` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `penjualan`
--

INSERT INTO `penjualan` (`id_penjualan`, `kode_transaksi_penjualan`, `tgl_penjualan`, `jumlah_barang`, `total_harga`, `bayar`, `kembali`, `status_penjualan`, `kode_pegawai`) VALUES
(1, 'TRSPJ2022060600001', '2022-06-06', 1, 20000, 20000, 0, 'Lunas', 'PGW0002'),
(2, 'TRSPJ2022060700001', '2022-06-07', 2, 40000, 50000, 10000, 'Lunas', 'PGW0002'),
(3, 'TRSPJ2022060800001', '2022-06-08', 4, 50000, 55000, 5000, 'Lunas', 'PGW0002'),
(4, 'TRSPJ2022060800002', '2022-06-08', 2, 39000, 40000, 1000, 'Lunas', 'PGW0003'),
(5, 'TRSPJ2022060900001', '2022-06-09', 2, 40000, 45000, 5000, 'Lunas', 'PGW0002'),
(6, 'TRSPJ2022060900002', '2022-06-09', 3, 29500, 30000, 500, 'Lunas', 'PGW0003'),
(7, 'TRSPJ2022060900003', '2022-06-09', 7, 35000, 50000, 15000, 'Lunas', 'PGW0001'),
(8, 'TRSPJ2022060900004', '2022-06-09', 5, 17500, 20000, 2500, 'Lunas', 'PGW0001'),
(9, 'TRSPJ2022061000001', '2022-06-10', 7, 19500, 20000, 500, 'Lunas', 'PGW0001');

-- --------------------------------------------------------

--
-- Struktur dari tabel `role`
--

CREATE TABLE `role` (
  `id_role` int(11) NOT NULL,
  `nama_role` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `role`
--

INSERT INTO `role` (`id_role`, `nama_role`) VALUES
(1, 'Administrator'),
(2, 'Kasir');

-- --------------------------------------------------------

--
-- Struktur dari tabel `supplier`
--

CREATE TABLE `supplier` (
  `id_supplier` int(11) NOT NULL,
  `kode_supplier` varchar(256) NOT NULL,
  `nama_supplier` varchar(256) NOT NULL,
  `alamat_supplier` text NOT NULL,
  `no_telp_supplier` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `supplier`
--

INSERT INTO `supplier` (`id_supplier`, `kode_supplier`, `nama_supplier`, `alamat_supplier`, `no_telp_supplier`) VALUES
(1, 'SPL0001', 'Abadi Sentosa', 'Surabaya', '081245344675'),
(2, 'SPL0002', 'Sumber Rejeki', 'Kepanjen', '085645675875'),
(3, 'SPL0003', 'Margo Mulyo', 'Wonokromo', '081235645645');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `nim` varchar(20) NOT NULL,
  `nama` varchar(256) NOT NULL,
  `image` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`nim`, `nama`, `image`) VALUES
('213140707111073', 'RAFIO SADANI', 'rafio.png'),
('213140707111086', 'MOKHAMAD SATRIYO NUGROHO', 'satriyo.png'),
('213140707111121', 'NAJWA KUSUMA MUSTAFA', 'najwa.png'),
('213140714111017', 'SISKA MAHARDIKA SULIANTO', 'siska.png'),
('213140714111167', 'SYAFIQ NOVENTA SUHARTONO PUTRA', 'syafiq.png');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`),
  ADD UNIQUE KEY `kode_barang` (`kode_barang`),
  ADD KEY `kode_kategori` (`kode_kategori`),
  ADD KEY `kode_supplier` (`kode_supplier`);

--
-- Indeks untuk tabel `detail_pembelian`
--
ALTER TABLE `detail_pembelian`
  ADD PRIMARY KEY (`id_detail_pembelian`),
  ADD KEY `kode_transaksi_pembelian` (`kode_transaksi_pembelian`),
  ADD KEY `kode_barang` (`kode_barang`),
  ADD KEY `kode_supplier` (`kode_supplier`);

--
-- Indeks untuk tabel `detail_penjualan`
--
ALTER TABLE `detail_penjualan`
  ADD PRIMARY KEY (`id_detail_penjualan`),
  ADD KEY `kode_transaksi_penjualan` (`kode_transaksi_penjualan`),
  ADD KEY `kode_barang` (`kode_barang`);

--
-- Indeks untuk tabel `kategori_barang`
--
ALTER TABLE `kategori_barang`
  ADD PRIMARY KEY (`id_kategori`),
  ADD UNIQUE KEY `kode_kategori` (`kode_kategori`);

--
-- Indeks untuk tabel `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id_pegawai`),
  ADD UNIQUE KEY `kode_pegawai` (`kode_pegawai`),
  ADD KEY `id_role` (`id_role`);

--
-- Indeks untuk tabel `pembelian`
--
ALTER TABLE `pembelian`
  ADD PRIMARY KEY (`id_pembelian`),
  ADD UNIQUE KEY `kode_transaksi_pembelian` (`kode_transaksi_pembelian`),
  ADD KEY `kode_pegawai` (`kode_pegawai`);

--
-- Indeks untuk tabel `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`id_penjualan`),
  ADD UNIQUE KEY `kode_transaksi_penjualan` (`kode_transaksi_penjualan`),
  ADD KEY `kode_pegawai` (`kode_pegawai`);

--
-- Indeks untuk tabel `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id_role`);

--
-- Indeks untuk tabel `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id_supplier`),
  ADD UNIQUE KEY `kode_supplier` (`kode_supplier`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD UNIQUE KEY `nim` (`nim`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `barang`
--
ALTER TABLE `barang`
  MODIFY `id_barang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT untuk tabel `detail_pembelian`
--
ALTER TABLE `detail_pembelian`
  MODIFY `id_detail_pembelian` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT untuk tabel `detail_penjualan`
--
ALTER TABLE `detail_penjualan`
  MODIFY `id_detail_penjualan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT untuk tabel `kategori_barang`
--
ALTER TABLE `kategori_barang`
  MODIFY `id_kategori` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `pegawai`
--
ALTER TABLE `pegawai`
  MODIFY `id_pegawai` int(16) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `pembelian`
--
ALTER TABLE `pembelian`
  MODIFY `id_pembelian` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `penjualan`
--
ALTER TABLE `penjualan`
  MODIFY `id_penjualan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT untuk tabel `role`
--
ALTER TABLE `role`
  MODIFY `id_role` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id_supplier` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `barang_ibfk_1` FOREIGN KEY (`kode_kategori`) REFERENCES `kategori_barang` (`kode_kategori`),
  ADD CONSTRAINT `barang_ibfk_2` FOREIGN KEY (`kode_supplier`) REFERENCES `supplier` (`kode_supplier`);

--
-- Ketidakleluasaan untuk tabel `detail_pembelian`
--
ALTER TABLE `detail_pembelian`
  ADD CONSTRAINT `detail_pembelian_ibfk_1` FOREIGN KEY (`kode_transaksi_pembelian`) REFERENCES `pembelian` (`kode_transaksi_pembelian`),
  ADD CONSTRAINT `detail_pembelian_ibfk_2` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`),
  ADD CONSTRAINT `detail_pembelian_ibfk_3` FOREIGN KEY (`kode_supplier`) REFERENCES `supplier` (`kode_supplier`);

--
-- Ketidakleluasaan untuk tabel `detail_penjualan`
--
ALTER TABLE `detail_penjualan`
  ADD CONSTRAINT `detail_penjualan_ibfk_1` FOREIGN KEY (`kode_transaksi_penjualan`) REFERENCES `penjualan` (`kode_transaksi_penjualan`),
  ADD CONSTRAINT `detail_penjualan_ibfk_2` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`);

--
-- Ketidakleluasaan untuk tabel `pegawai`
--
ALTER TABLE `pegawai`
  ADD CONSTRAINT `pegawai_ibfk_1` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`);

--
-- Ketidakleluasaan untuk tabel `pembelian`
--
ALTER TABLE `pembelian`
  ADD CONSTRAINT `pembelian_ibfk_2` FOREIGN KEY (`kode_pegawai`) REFERENCES `pegawai` (`kode_pegawai`);

--
-- Ketidakleluasaan untuk tabel `penjualan`
--
ALTER TABLE `penjualan`
  ADD CONSTRAINT `penjualan_ibfk_2` FOREIGN KEY (`kode_pegawai`) REFERENCES `pegawai` (`kode_pegawai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
